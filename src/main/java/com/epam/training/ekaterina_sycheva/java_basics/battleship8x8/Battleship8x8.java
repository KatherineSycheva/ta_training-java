package com.epam.training.ekaterina_sycheva.java_basics.battleship8x8;

import java.util.List;

/**
 * A class representing a 8x8 map for Battleship game.
 */
public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    /**
     * Returns the position at 8x8 map. A position
     * ranges from <code>0</code> to <code>63</code>.
     *
     * @param  coordinates String in format of 'A1', 'C5' etc.
     * @return the position at the map.
     */
    public int position (String coordinates) {
        int vertical_pos =  ((int) coordinates.charAt(0)) - 65;
        int horizontal_pos = Integer.parseInt(String.valueOf(coordinates.charAt(1)));
        return (horizontal_pos-1)*8 + vertical_pos;
    }

    /**
     * Returns the binary form of value as a string.
     * @param value to parse to char array
     */
    public char[] longToCharArray(long value) {
        return String.format("%64s", Long.toBinaryString(value)).replace(' ', '0').toCharArray();
    }

    /**
     * Registers a shot and returns true if the shot hits a ship.
     * @param shot a combination of one of A-H letters and one of 1-8 digits
     * @return true if the shot hits a ship
     */
    public boolean shoot(String shot) {
        long start_state = 0b1111111111111111111111111111111111111111111111111111111111111111L;
        int position = position(shot);
        shots = shots | ((start_state>>>position) & (start_state << 63-position));
        return longToCharArray(ships)[position] == '1';
    }

    /**
     * Returns a string representing state of the map
     *
     * @return the string with 8 lines per 8 characters separated by "\n" and containing symbols:
     * '.' - an empty cell,
     * '×' - an empty cell that has been shot,
     * '☐' - a cell seized by a ship,
     * '☒'- a cell seized by a ship that has been shot.
     */
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
