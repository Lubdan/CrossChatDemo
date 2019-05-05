package lubdan.crosschat.jdaevents;

import lubdan.crosschat.CrossChat;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.bukkit.Bukkit;

public class messagereceived extends ListenerAdapter {



    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        if(event.getChannel().getIdLong() == CrossChat.getProvidingPlugin(CrossChat.class).getConfig().getLong("channel") && !event.getAuthor().isBot()){


            Bukkit.broadcastMessage(event.getAuthor().getName() + " said " + event.getMessage().getContentRaw());





        }










    }
}
