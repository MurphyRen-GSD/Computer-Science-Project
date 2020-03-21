package enigma;

import static enigma.EnigmaException.*;

/** Superclass that represents a rotor in the enigma machine.
 *  @author
 */
public class Rotor {

    /** A rotor named NAME whose permutation is given by PERM. */
    public Rotor(String name, Permutation perm) {
        _name = name;
        _permutation = perm;
        _setting = 0;
        // FIXME - Assign any additional instance variables.
    }

    /** Return my name. */
    public String name() {
        return _name;
    }

    /** Return my alphabet. */
    public Alphabet alphabet() {
        return _permutation.alphabet();
    }

    /** Return my permutation. */
    public Permutation permutation() {
        return _permutation;
    }

    /** Return the size of my alphabet. */
    public int size() {
        return _permutation.size();
    }

    /** Return true if and only if I have a ratchet and can move. */
    public boolean rotates() {
        return false;
    }

    /** Return true if and only if I reflect. */
    public boolean reflecting() {
        return false;
    }

    /** Return my current setting. */
    public int setting() {
        return _setting; // FIXME - How do we keep track of my current position?
    }

    /** Set setting() to POSN.  */
    public void set(int posn) {
        _setting = posn;
        // FIXME - How do we update our current position, based on an alphabet index?
    }

    /** Set setting() to character CPOSN. */
    public void set(char cposn) {
        int intposn = _permutation.alphabet().toInt(cposn);
        _setting = intposn;
        // FIXME - How do we update our current position, based on an alphabet character?
    }

    /** Return the conversion of P (an integer in the range 0..size()-1)
     *  according to my permutation. */
    public int convertForward(int p) {
        int cIn = _permutation.wrap(p + _setting);
        int cOut = _permutation.permute(cIn);
        int result = _permutation.wrap(cOut - _setting);
        return result;
        // FIXME - How do we permute the index P, taking into account my current position?
    }

    /** Return the conversion of C (an integer in the range 0..size()-1)
     *  according to the inverse of my permutation. */
    public int convertBackward(int c) {
        int cIn = _permutation.wrap(c + _setting);
        int cOut = _permutation.invert(cIn);
        int result = _permutation.wrap(cOut - _setting);
        return result;
        // FIXME - How do we invert the index E, taking into account my current position?
    }

    /** Returns true if and only if I am positioned to allow the rotor
     * to my left to advance. */
    public boolean atNotch() {
        return false;
    }
    

    boolean trythis() {
        return false;
    }

    /** Advance me one position, if possible. By default, does nothing. */
    public void advance() {
    }

    @Override
    public String toString() {
        return "Rotor " + _name;
    }

    /** My name. */
    private final String _name;

    /** The permutation implemented by this rotor in its 0 position. */
    private Permutation _permutation;

    // FIXME - How do we keep track of what position I am in?
    private int _setting;

    // FIXME: ADDITIONAL FIELDS HERE, AS NEEDED
    private Alphabet _alphabet;
}
