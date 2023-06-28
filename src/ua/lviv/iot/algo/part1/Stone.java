package ua.lviv.iot.algo.part1;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public abstract class Stone {

    public String name;
    public String color;
    public double weightInGrams;
    public double pricePerGram;

    public double getFullPrice(){
        return 0;
    }

}