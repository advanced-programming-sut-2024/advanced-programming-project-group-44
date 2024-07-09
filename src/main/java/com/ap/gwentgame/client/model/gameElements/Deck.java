package com.ap.gwentgame.client.model.gameElements;

import com.ap.gwentgame.client.enums.FactionType;
import com.ap.gwentgame.client.model.Abilities.Ability;
import com.ap.gwentgame.client.model.PropertyMarshallerAbstractTask;
import com.ap.gwentgame.client.view.ViewUtilities;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Deck {
    private final ArrayList<PreGameCard> PreGameCards;
    private final Leader leader;
    private final FactionType factionType;

    private static final GsonBuilder builder = new GsonBuilder().registerTypeAdapter(Card.class,
            new PropertyMarshallerAbstractTask()).registerTypeAdapter(Ability.class,
            new PropertyMarshallerAbstractTask()).registerTypeAdapter(Leader.class,
            new PropertyMarshallerAbstractTask());
    private static final Gson gson = builder.create();

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
            String deckString = gson.toJson(deck);
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
                return gson.fromJson(reader, Deck.class);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            ViewUtilities.showErrorAlert("No file selected", "You have to select a file to upload your deck!");
        }

        return null;
    }
}
