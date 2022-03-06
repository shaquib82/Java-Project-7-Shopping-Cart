package com.company;

public class Store2 {
    private Item2 [][] items;

    public Store2(){
        this.items = new Item2[7][3];
    }

    public Item2 getItem(int row,int column) {
        return new Item2(this.items[row][column]);
    }

    public void setItem(int row, int column, Item2 item) {
        this.items[row][column]= new Item2(item);
    }
    
    public String toString(){
        String temp = "";
        for (int i = 0; i <7 ; i++) {
            switch (i) {
                case 0: temp += "\tDRINKS:        "; break;
                case 1: temp += "\tCEREAL:        "; break;
                case 2: temp += "\tDAIRY:         "; break;
                case 3: temp += "\tDELI:          "; break;
                case 4: temp += "\tGREENS:        "; break;
                case 5: temp += "\tCLOTHING:      "; break;
                case 6: temp += "\tELECTRONICS:   "; break;
            }
            for (int j = 0; j <3 ; j++) {
                temp += this.items[i][j].toString();
            }
            temp+="\n\n";
        }
        temp +="\t************************************************************************\n";

        return temp;
    }
    
    
    
}
