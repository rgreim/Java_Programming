package util;

import java.util.Iterator;

/**
 * Motivsuche
 *
 * @author R.Greim
 * @version 0.1
 */
public class K_mer implements Iterable<K_mer> {

    private int length;
    private String sequence;

    public K_mer(int length) {
        this.length = length;
    }

    public K_mer(String sequence) {
        this.sequence = sequence;
    }

    public String toString() {
        return sequence;
    }


    @Override
    public Iterator<K_mer> iterator() {
        return new K_merIterator(length);
    }

    private class K_merIterator implements Iterator<K_mer> {

        private String sequence = "";
        private String endSequence = "";
        private int l;


        public K_merIterator(int length) {
            this.l = length;
            for (int i = 0; i < l; i++) {
                endSequence += "T";
            }

        }

        @Override
        public boolean hasNext() {
            return !(sequence.equals(endSequence));
        }

        @Override
        public K_mer next() {
            if (sequence.isEmpty()) {
                for (int i = 0; i < l; i++) {
                    sequence += "A";
                }
            } else {
                countUp(l - 1);
            }
            return new K_mer(sequence);
        }

        private void countUp(int pos) {
            if (hasNext()) {
                switch (sequence.charAt(pos)) {
                    case 'A':
                        changeChar(pos, 'C');
                        break;
                    case 'C':
                        changeChar(pos, 'G');
                        break;
                    case 'G':
                        changeChar(pos, 'T');
                        break;
                    case 'T':
                        changeChar(pos, 'A');
                        countUp(pos - 1);
                }
            }
        }

        private void changeChar(int pos, char c) {
            StringBuilder sb = new StringBuilder(sequence);
            sb.setCharAt(pos, c);
            sequence = sb.toString();
        }

    }
}
