package CommandForDynmap;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class CommandForDynmap extends JavaPlugin {

    private String dynmapUrl;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("CommandForDynmap is now enable!");
        //コマンドをplugin.ymlの設定と合致させる
        this.getCommand("map").setExecutor(this);

        //config.ymlの生成
        saveDefaultConfig();

        //config.ymlからURLの読み込みと、dynmapUrlへの格納
        dynmapUrl = getConfig().getString("URL");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("CommandForDynmap is now disable!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //パーミッション
        if (sender.hasPermission("CommandForDynmap.commands.map")) {
            //送信されたコマンドがmapと適合するかの検証
            if (command.getName().equalsIgnoreCase("map")) {
                //送信者がプレイヤーかどうかの判定
                if (sender instanceof Player) {
                    //プレイヤーの場合、CommandSenderのsenderをPlayerにする
                    Player player = (Player) sender;
                    player.sendMessage("§aDynmapURL" + "§f : "  + dynmapUrl);
                } else {
                    //コンソールの場合、そのままログ出力
                    sender.sendMessage("DynmapURL : " + dynmapUrl);
                }
                return true;
            } else {
                //送信されたコマンドがmapと適合しない場合
                return false;
            }
        } else {
            sender.sendMessage("§4 You do not have permission");
            return false;
        }
    }

}
