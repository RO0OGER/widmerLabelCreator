package ch.iet_gibb.model;

/**
 * Die Klasse Tank repräsentiert einen generischen Wassertank, der bestimmte Parameter hat.
 */
public class Tank {
    /**
     * Die maximale Temperatur, die der Tank speichern kann.
     */
    private float maxTemperature;

    /**
     * Der Name des Tanks.
     */
    private String name;

    /**
     * Das Volumen des Tanks in Litern.
     */
    private float volume;

    /**
     * Die tägliche Energie, die vom Tank verbraucht wird, in kWh.
     */
    private float dailyEnergy;

    /**
     * Konstruktor der Tank-Klasse.
     *
     * @param maxTemperature Die maximale Temperatur des Tanks.
     * @param name Der Name des Tanks.
     * @param volume Das Volumen des Tanks in Litern.
     * @param dailyEnergy Die tägliche Energie, die der Tank verbraucht.
     */
    public Tank(float maxTemperature, String name, float volume, float dailyEnergy) {
        setMaxTemperature(maxTemperature);
        setName(name);
        setVolume(volume);
        setDailyEnergy(dailyEnergy);
    }

    /**
     * Berechnet, wie lange der Tank heizen kann, basierend auf der gespeicherten Energie und dem täglichen Energieverbrauch.
     *
     * @return Die Anzahl der Tage, die der Tank heizen kann.
     */
    public float calculateDaysHeated() {
        return calculateStoredEnergy() / dailyEnergy;
    }

    /**
     * Berechnet die im Tank gespeicherte Energie in kWh.
     *
     * @return Die gespeicherte Energie in kWh.
     */
    public float calculateStoredEnergy() {
        return (int) (volume * 4.18 * (maxTemperature - 23) / (double) 3600);
    }

    /**
     * Gibt eine Textdarstellung des Tanks zurück, einschließlich des Volumens, der gespeicherten Energie,
     * des täglichen Energieverbrauchs, der Anzahl der Heizungstage, des Namens und der maximalen Temperatur.
     *
     * @return Die String-Darstellung des Tanks.
     */
    @Override
    public String toString() {
        return "Fassungsvermögen: " + volume + " Liter\n" +
                "Gespeicherte Energie: " + calculateStoredEnergy() + " kWh\n" +
                "Tägliche Energie: " + dailyEnergy + " kWh\n" +
                "Tage heizen: " + calculateDaysHeated() + " Tage\n" +
                "Name: " + name + "\n" +
                "Maximale Temperatur: " + maxTemperature + "Grad Celsius";
    }

    // Getter und Setter mit Validierung:

    /**
     * Setzt die maximale Temperatur des Tanks.
     *
     * @param maxTemperature Die maximale Temperatur in Grad Celsius.
     */
    public void setMaxTemperature(float maxTemperature) {
        if (maxTemperature < 30) {
            throw new IllegalArgumentException("Maximale Temperatur darf nicht unter 30 Grad Celsius liegen.");
        }
        this.maxTemperature = maxTemperature;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name darf nicht leer sein.");
        }
        this.name = name;
    }

    public void setVolume(float volume) {
        if (volume <= 0) {
            throw new IllegalArgumentException("Volumen muss größer als 0 sein.");
        }
        this.volume = volume;
    }

    public void setDailyEnergy(float dailyEnergy) {
        if (dailyEnergy <= 0) {
            throw new IllegalArgumentException("Tägliche Energie muss größer als 0 sein.");
        }
        this.dailyEnergy = dailyEnergy;
    }

    // Getter
    public float getMaxTemperature() {
        return maxTemperature;
    }

    public String getName() {
        return name;
    }

    public float getVolume() {
        return volume;
    }

    public float getDailyEnergy() {
        return dailyEnergy;
    }
}
