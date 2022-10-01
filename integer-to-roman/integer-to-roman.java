class Solution {
    public String intToRoman(int num) {
        Roman[] list = new Roman[] {
            new Roman("M", 1000),
            new Roman("CM", 900),
            new Roman("D", 500),
            new Roman("CD", 400),
            new Roman("C", 100),
            new Roman("XC", 90),
            new Roman("L", 50),
            new Roman("XL", 40),
            new Roman("X", 10),
            new Roman("IX", 9),
            new Roman("V", 5),
            new Roman("IV", 4),
            new Roman("I", 1)
        };
        
        String result = "";
        int pointer = 0;
        
        while(num > 0) {
            while (list[pointer].numericValue > num) pointer++;
            result += list[pointer].value;
            num -= list[pointer].numericValue;
        }
        
        return result;
    }
    
    class Roman {
        public String value = "";
        public int numericValue = 0;
        
        public Roman(String value, int numericValue) {
            this.value = value;
            this.numericValue = numericValue;
        }
    }
}