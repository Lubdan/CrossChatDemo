package lubdan.crosschat.spigotevents;

import lubdan.crosschat.CrossChat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {


    private CrossChat chat;

  public  ChatEvent(CrossChat mainclass){

        this.chat = mainclass;

    }






    @EventHandler
    public void chatEvent(AsyncPlayerChatEvent event){


      String message = event.getMessage();
      String output = event.getPlayer().getName() + " said " + message;
      this.chat.addString(output);





    }


}
