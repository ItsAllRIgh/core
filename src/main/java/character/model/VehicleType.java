package character.model;

public enum VehicleType {
    Gravsled(0), SpeederBike(1), Skiff(2), Airspeeder(3), CloudCar(4), SpeederTruck(5), SwoopBike(6), Landspeeder(7), MobileRefinery(8), GroundCar(9), ArmoredPersonnelCarrier(10), TunnelingVehicle(11), HeavyAssaultWalker(12), ReconnaissanceWalker(13), CargoSkiff(14), DriodOperatedVehicle(15), SailBarge(16), AerialRetreat(17), Submarine(18), WheelBike(19), HeavyLandspeeder(20), HeavyCargoLoader(21);
    int val;

    VehicleType(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public String valToString(int val) {
        return this.toString();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
