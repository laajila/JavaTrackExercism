class SpaceAge {
    double ageInSeconds=0;
    SpaceAge(double seconds) {
      ageInSeconds=seconds;
    }

    double getSeconds() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    double onEarth() {
        return ageInSeconds/31557600;
    }

    double onMercury() {
        return (ageInSeconds/31557600)/0.2408467;
    }

    double onVenus() {
        return (ageInSeconds/31557600)/0.61519726;
    }

    double onMars() {
        return (ageInSeconds/31557600)/1.8808158;
    }

    double onJupiter() {
        return (ageInSeconds/31557600)/11.862615;
    }

    double onSaturn() {
        return (ageInSeconds/31557600)/29.447498;
    }

    double onUranus() {
        return (ageInSeconds/31557600)/84.016846;
    }

    double onNeptune() {
        return (ageInSeconds/31557600)/164.79132;
    }

}
