package ru.job4j.stream;

import ru.job4j.poly.Plane;

public class Planet {
    private String name;
    private int orbitalPosition;
    private int radius;
    private boolean atmosphere;
    private boolean worldOcean;
    private boolean magnetosphere;
    private int numberOfSatellite;

    static class Builder {
        private String name;
        private int orbitalPosition;
        private int radius;
        private boolean atmosphere;
        private boolean worldOcean;
        private boolean magnetosphere;
        private int numberOfSatellite;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildOrbitalPosition(int orbitalPosition) {
            this.orbitalPosition = orbitalPosition;
            return this;
        }

        Builder buildRadius(int radius) {
            this.radius = radius;
            return this;
        }

        Builder buildAtmosphere(boolean atmosphere) {
            this.atmosphere = atmosphere;
            return this;
        }

        Builder buildWorldOcean(boolean worldOcean) {
            this.worldOcean = worldOcean;
            return this;
        }

        Builder buildMagnetosphere(boolean magnetosphere) {
            this.magnetosphere = magnetosphere;
            return this;
        }

        Builder buildNumberOfSatellite(int numberOfSatellite) {
            this.numberOfSatellite = numberOfSatellite;
            return this;
        }

        Planet build() {
            Planet planet = new Planet();
            planet.name = name;
            planet.orbitalPosition = orbitalPosition;
            planet.radius = radius;
            planet.atmosphere = atmosphere;
            planet.worldOcean = worldOcean;
            planet.magnetosphere = magnetosphere;
            planet.numberOfSatellite = numberOfSatellite;
            return planet;
        }
    }

    @Override
    public String toString() {
        return "Planet{"
                + "name='" + name + '\''
                + ", orbitalPosition=" + orbitalPosition
                + ", radius=" + radius
                + ", atmosphere=" + atmosphere
                + ", worldOcean=" + worldOcean
                + ", magnetosphere=" + magnetosphere
                + ", numberOfSatellite=" + numberOfSatellite
                + '}';
    }

    public static void main(String[] args) {
        Planet planet = new Builder().buildName("Mars")
                .buildOrbitalPosition(4)
                .buildRadius(3389)
                .buildAtmosphere(true)
                .buildWorldOcean(false)
                .buildMagnetosphere(false)
                .buildNumberOfSatellite(2)
                .build();

        System.out.println(planet.toString());
    }
}
