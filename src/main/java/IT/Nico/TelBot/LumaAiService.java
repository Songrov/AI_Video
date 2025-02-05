package IT.Nico.TelBot;

import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Service
public class LumaAiService {
    private static final String API_URL = "https://api.lumalabs.ai/dream-machine/v1/generations";
    private static final String API_KEY = "luma-a25f4e10-8952-4f54-b75c-651fd6c2eb7b-c51e0790-9fd2-4e22-91d2-d32e9f283aaa";

    private final RestTemplate restTemplate = new RestTemplate();

    public String generate3DModel(String prompt) {
        // Заголовки запроса
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + API_KEY);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Тело запроса
        JSONObject requestBody = new JSONObject();
        requestBody.put("generation_type", "video");
        requestBody.put("prompt", prompt);
        requestBody.put("aspect_ratio", "16:9");
       // requestBody.put("--ar", "9:16");
        requestBody.put("model", "ray-1-6");

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody.toString(), headers);

        // Отправляем запрос
        ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.POST, requestEntity, String.class);

        // Парсим JSON-ответ
        JSONObject jsonResponse = new JSONObject(response.getBody());
        String requestId = jsonResponse.getString("id");

        // Ждём генерации модели
        return waitForModel(requestId);
    }
    private String waitForModel(String requestId) {
        String statusUrl = API_URL + "/" + requestId;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + API_KEY);

        for (int i = 0; i < 30; i++) { // Ожидаем максимум 30 раз (5 минут)
            HttpEntity<String> requestEntity = new HttpEntity<>(headers);
            ResponseEntity<String> response = restTemplate.exchange(statusUrl, HttpMethod.GET, requestEntity, String.class);

            JSONObject jsonResponse = new JSONObject(response.getBody());
            String state = jsonResponse.getString("state");

            if ("completed".equals(state)) {
                JSONObject assets = jsonResponse.getJSONObject("assets"); // Получаем объект assets
                return assets.getString("video"); // Получаем ссылку на видео
            } else if ("failed".equals(state)) {
                return "Ошибка генерации модели.";
            }

            try {
                TimeUnit.SECONDS.sleep(10); // Ждём 10 секунд перед повторной проверкой
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return "Процесс генерации был прерван.";
            }
        }

        return "Генерация заняла слишком много времени.";
    }
}