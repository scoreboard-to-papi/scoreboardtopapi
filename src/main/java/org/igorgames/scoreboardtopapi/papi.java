package org.igorgames.scoreboardtopapi;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.jetbrains.annotations.NotNull;

public class papi extends PlaceholderExpansion {
    @Override
    public @NotNull String getIdentifier() {
        return "scoreboardpapi";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Igorgames";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }
    @Override
    public String onPlaceholderRequest(Player player, @NotNull String params) {
        // %scoreboardpapi_Money_localplayer% or %scoreboardpapi_Money_Admin%
        if (player == null) return "";

        String[] parts = params.split("_", 2);
        if (parts.length != 2) return "";

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getMainScoreboard();

        String scoreboardName = parts[0];
        String targetPlayerName = parts[1];

        if (targetPlayerName.equalsIgnoreCase("localplayer")) {
            Objective objective = board.getObjective(scoreboardName);
            if (objective != null) {
                Score score = objective.getScore(player.getName());
                return String.valueOf(score.getScore());
            }
        } else {
            Objective objective = board.getObjective(scoreboardName);
            if (objective != null) {
                Score score = objective.getScore(targetPlayerName);
                return String.valueOf(score.getScore());
            }
        }
        return null;
    }
}
