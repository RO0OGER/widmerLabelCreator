package ch.iet_gibb;

import ch.iet_gibb.model.CubicTank;
import ch.iet_gibb.model.CylindricalTank;
import ch.iet_gibb.model.Tank;

/**
 * @author Roger Widmer
 * @version 1.0
 * @since 1.0.0
 */
public class HeatCalculator {

    /**
     * Hauptmethode: Erzeugt Tank-Objekte und gibt deren Details aus.
     *
     * @param args Kommandozeilenargumente (nicht verwendet)
     */
    public static void main(String[] args) {
        // Tank-Objekt mit Kapazität 70, Name "Fredi", Volumen 1000, Temperatur 20
        Tank tank = new Tank(70, "Fredi", 1000, 20);

        // CubicTank-Objekt mit Kapazität 80, Name "Ueli", Volumen 400, Höhe 100, Breite 200, Tiefe 100
        CubicTank cubicTank = new CubicTank(80, "Ueli", 400, 100, 200, 100);

        // CylindricalTank-Objekt mit Kapazität 80, Name "Lisbeth", Volumen 400, Durchmesser 100, Höhe 200
        CylindricalTank cylindricalTank = new CylindricalTank(80, "Lisbeth", 400, 100, 200);

        // Ausgabe des CylindricalTank-Objekts
        System.out.println(cylindricalTank);

        // Ausgabe des CubicTank-Objekts
        System.out.println(cubicTank);

        // Ausgabe des Tank-Objekts
        System.out.println(tank);
    }
}
