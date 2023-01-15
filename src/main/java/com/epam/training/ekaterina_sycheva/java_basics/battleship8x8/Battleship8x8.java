package com.epam.training.ekaterina_sycheva.java_basics.battleship8x8;

import java.util.List;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public int position (String coordinates) {
        int vertical_pos =  ((int) coordinates.charAt(0)) - 65;
        int horizontal_pos = Integer.parseInt(String.valueOf(coordinates.charAt(1)));
        return (horizontal_pos-1)*8 + vertical_pos;
    }

    public char[] longToCharArray(long value) {
        return String.format("%64s", Long.toBinaryString(value)).replace(' ', '0').toCharArray();
    }

    public boolean shoot(String shot) {
        long start_state = 0b1111111111111111111111111111111111111111111111111111111111111111L;
        int position = position(shot);
        shots = shots | ((start_state>>>position) & (start_state << 63-position));
        return longToCharArray(ships)[position] == '1';
    }


    public String state() {
        char [] ships_char_array = longToCharArray(ships);
        char [] shots_char_array = longToCharArray(shots);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < ships_char_array.length; i++) {
            if (ships_char_array[i]=='0' && shots_char_array[i]=='0') {
                builder.append(".");
            } else if (ships_char_array[i]=='0' && shots_char_array[i]=='1') {
                builder.append("×");
            } else if (ships_char_array[i]=='1' && shots_char_array[i]=='0') {
                builder.append("☐");
            } else {
                builder.append("☒");
            }
            if (i < ships_char_array.length-1 && (i+1) % 8 == 0) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        long map = 0b11111000_00000000_00000000_00011000_00000000_00001000_00000000_00000111L;
        List<String> shots = List.of("H8", "G8", "F8", "D4");
        Battleship8x8 battle = new Battleship8x8(map);
        for (String s: shots) {
            battle.shoot(s);
        }
    }
}
