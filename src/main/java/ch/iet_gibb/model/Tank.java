package ch.iet_gibb.model;

/**
 * Die Klasse Tank repräsentiert einen allgemeinen Tank.
 *
 * @author Roger Widmer
 * @version 1.0
 * @since 1.0.0
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
     * @param dailyEnergy Die tägliche Energie des Tanks in kWh.
     */
    public Tank(float maxTemperature, String name, float volume, float dailyEnergy) {
        setMaxTemperature(maxTemperature);
        setName(name);
        setVolume(volume);
        setDailyEnergy(dailyEnergy);
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
     * Berechnet, wie lange der Tank heizen kann, basierend auf der gespeicherten Energie und dem täglichen Energieverbrauch.
     *
     * @return Die Anzahl der Tage, die der Tank heizen kann.
     */
    public float calculateDaysHeated() {
        return calculateStoredEnergy() / dailyEnergy;
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

    // Getter und Setter:

    /**
     * Gibt die maximale Temperatur des Tanks zurück.
     *
     * @return Die maximale Temperatur.
     */
    public float getMaxTemperature() {
        return maxTemperature;
    }

    /**
     * Setzt die maximale Temperatur des Tanks.
     *
     * @param maxTemperature Die maximale Temperatur des Tanks.
     * @throws IllegalArgumentException Wenn die Temperatur unter 30 Grad Celsius liegt.
     */
    public void setMaxTemperature(float maxTemperature) {
        if (maxTemperature < 30) {
            throw new IllegalArgumentException("Maximale Temperatur darf nicht unter 30 Grad Celsius liegen.");
        }
        this.maxTemperature = maxTemperature;
    }

    /**
     * Gibt den Namen des Tanks zurück.
     *
     * @return Der Name des Tanks.
     */
    public String getName() {
        return name;
    }

    /**
     * Setzt den Namen des Tanks.
     *
     * @param name Der Name des Tanks.
     * @throws IllegalArgumentException Wenn der Name leer oder null ist.
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name darf nicht leer sein.");
        }
        this.name = name;
    }

    /**
     * Gibt das Volumen des Tanks zurück.
     *
     * @return Das Volumen des Tanks in Litern.
     */
    public float getVolume() {
        return volume;
    }

    /**
     * Setzt das Volumen des Tanks.
     *
     * @param volume Das Volumen des Tanks in Litern.
     * @throws IllegalArgumentException Wenn das Volumen kleiner oder gleich null ist.
     */
    public void setVolume(float volume) {
        if (volume <= 0) {
            throw new IllegalArgumentException("Volumen muss größer als 0 sein.");
        }
        this.volume = volume;
    }

    /**
     * Gibt die tägliche Energie des Tanks zurück.
     *
     * @return Die tägliche Energie in kWh.
     */
    public float getDailyEnergy() {
        return dailyEnergy;
    }

    /**
     * Setzt die tägliche Energie des Tanks.
     *
     * @param dailyEnergy Die tägliche Energie in kWh.
     * @throws IllegalArgumentException Wenn die tägliche Energie kleiner oder gleich null ist.
     */
    public void setDailyEnergy(float dailyEnergy) {
        if (dailyEnergy <= 0) {
            throw new IllegalArgumentException("Tägliche Energie muss größer als 0 sein.");
        }
        this.dailyEnergy = dailyEnergy;
    }
}
