class ParkingSystem {
    int[] available = null;

    public ParkingSystem(int big, int medium, int small) {
        available = new int[] {big, medium, small};
    }
    
    public boolean addCar(int carType) {
        if (available[carType - 1] > 0) {
            available[carType - 1]--;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */