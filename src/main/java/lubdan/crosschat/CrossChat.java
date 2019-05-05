package lubdan.crosschat;

import lubdan.crosschat.jdaevents.messagereceived;
import lubdan.crosschat.spigotevents.ChatEvent;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class CrossChat extends JavaPlugin {

    ArrayList<String> messages;
    private Thread thread;

    @Override
    public void onEnable() {


        messages = new ArrayList<>();
        getServer().getPluginManager().registerEvents(new ChatEvent(this), this);

        getConfig().options().copyDefaults();
        saveDefaultConfig();






















        botHandler();
    }

    @Override
    public void onDisable() {
        thread.interrupt();
    }



    public void addString(String context){

        messages.add(context);


    }

    private void botHandler() {
        thread = new Thread(){
            @Override
            public void run() {
                super.run();

                try{

                    JDA jda = new JDABuilder(getConfig().getString("token")).build();
                    jda.addEventListener(new messagereceived());






                    while(true){

                        while(messages.size() != 0){

                            jda.getTextChannelById(getConfig().getLong("channel")).sendMessage(messages.get(messages.size() - 1)).queue();
                            messages.remove(messages.size() - 1);
                            System.out.println("Message sent successfully");



                        }







                        Thread.sleep(3000);
                    }

                }
                catch(Exception e){
                    System.out.println(e.getLocalizedMessage());
                }








            }
        };
        thread.start();


    }






}
