package CommandForDynmap;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class CommandForDynmap extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("CommandForDynmap is now enable!");
        //コマンドをplugin.ymlの設定と合致させる
        this.getCommand("map").setExecutor(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("CommandForDynmap is now disable!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //送信されたコマンドがmapと適合するかの検証
        if (command.getName().equalsIgnoreCase("map")) {
            String dynmapUrl = "https://map.bokukoha.dev";
            //送信者がプレイヤーかどうかの判定
            if (sender instanceof Player) {
                //プレイヤーの場合、CommandSenderのsenderをPlayerにする
                Player player = (Player) sender;
                player.sendMessage("DynmapURL : "  + dynmapUrl);
            } else {
                //コンソールの場合、そのままログ出力
                sender.sendMessage("DynmapURL : " + dynmapUrl);
            }
            return true;
        } else {
            //送信されたコマンドがmapと適合しない場合
            return false;
        }
    }

}
