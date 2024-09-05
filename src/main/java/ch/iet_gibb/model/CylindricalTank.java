package ch.iet_gibb.model;

/**
 * Die Klasse CylindricalTank repräsentiert einen zylindrischen Tank.
 */
public class CylindricalTank {
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
     * Die Höhe des Tanks in cm.
     */
    private float height;

    /**
     * Der Durchmesser des Tanks in cm.
     */
    private float width;

    /**
     * Konstruktor der CylindricalTank-Klasse.
     *
     * @param maxTemperature Die maximale Temperatur des Tanks.
     * @param name Der Name des Tanks.
     * @param dailyEnergy Die tägliche Energie des Tanks in kWh.
     * @param height Die Höhe des Tanks in cm.
     * @param width Der Durchmesser des Tanks in cm.
     */
    public CylindricalTank(float maxTemperature, String name, float dailyEnergy, float height, float width) {
        setMaxTemperature(maxTemperature);
        setName(name);
        setDailyEnergy(dailyEnergy);
        setHeight(height);
        setWidth(width);
        this.volume = calculateRoundTankVolumeInLiters();
    }

    /**
     * Berechnet das Volumen des zylindrischen Tanks basierend auf seinen Abmessungen.
     *
     * @return Das Volumen des Tanks in Litern.
     */
    public int calculateRoundTankVolumeInLiters() {
        return (int) ((Math.PI * width * width * height) / 4 / 1000);
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

    // Setter mit Validierungen:

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

    public void setDailyEnergy(float dailyEnergy) {
        if (dailyEnergy <= 0) {
            throw new IllegalArgumentException("Tägliche Energie muss größer als 0 sein.");
        }
        this.dailyEnergy = dailyEnergy;
    }

    public void setHeight(float height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Höhe muss größer als 0 sein.");
        }
        this.height = height;
    }

    public void setWidth(float width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Durchmesser muss größer als 0 sein.");
        }
        this.width = width;
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

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }
}
