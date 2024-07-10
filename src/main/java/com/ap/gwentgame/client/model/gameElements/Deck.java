package com.ap.gwentgame.client.model.gameElements;

import com.ap.gwentgame.ClientCommands;
import com.ap.gwentgame.client.Client;
import com.ap.gwentgame.client.enums.FactionType;
import com.ap.gwentgame.client.model.Abilities.Ability;
import com.ap.gwentgame.client.model.PropertyMarshallerAbstractTask;
import com.ap.gwentgame.client.view.ViewUtilities;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.ArrayList;

public class Deck implements Serializable {
    private final ArrayList<PreGameCard> PreGameCards;
    private final Leader leader;
    private final FactionType factionType;

    public Deck(ArrayList<PreGameCard> preGameCards, Leader leader, FactionType factionType) {
        PreGameCards = preGameCards;
        this.leader = leader;
        this.factionType = factionType;
    }

    public ArrayList<PreGameCard> getPreGameCards() {
        return PreGameCards;
    }

    public Leader getLeader() {
        return leader;
    }

    public FactionType getFactionType() {
        return factionType;
    }

    public static void download(Deck deck) {
        try {
            String deckString = Client.getGson().toJson(deck);
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON Files", "*.json"));
            File selectedFile = fileChooser.showSaveDialog(null);
            if (selectedFile != null) {
                FileWriter writer = new FileWriter(selectedFile);
                writer.write(deckString);
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Deck upload() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON Files", "*.json"));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            try {
                FileReader reader = new FileReader(selectedFile);
                return Client.getGson().fromJson(reader, Deck.class);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            ViewUtilities.showErrorAlert("No file selected", "You have to select a file to upload your deck!");
        }

        return null;
    }
}
