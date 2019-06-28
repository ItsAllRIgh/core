package character.model;

public enum StarshipType {
    Starfighter(0), PatrolBoat(1), Shuttle(2), Transport(3), Freighter(4), Yacht(5), Corvette(6), Frigate(7), ScoutShip(8), BulkFrighter(9), LightAssaultTransport(10), BulkCruiser(11), Cruiser(12), LightFreighter(13), RacingVessel(14), LightCruiser(15), ArmedTransport(16), HeavyCruiser(17), StarDestroyer(18), StarBattlecruiser(19), HeavyStarCruiser(20), HeavyFreighter(21), EscapePod(22), DroidOperated(23), Starliner(24), Carrier(25), AssaultStarfighter(26), AssaultShip(27), SpaceDefensePlatform(28), Barge(29), Destoryer(30), Dreadnaught(31), BattleCruiser(32), Gunship(33), Courer(34);
    private int val;

    StarshipType(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
