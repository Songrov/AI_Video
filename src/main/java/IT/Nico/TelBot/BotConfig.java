package IT.Nico.TelBot;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Data
@PropertySource("application.properties")
public class BotConfig {
    @Value("${telegram.bot.username}")
    String botName = "IT_Nico_bot";
    @Value("${telegram.bot.token}")
    String token = "7815802972:AAHnNPIXRgSZbgxcRmJ4M4qAuIF4NRyEoiI";
}


