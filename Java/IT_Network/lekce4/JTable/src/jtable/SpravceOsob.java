package jtable;

import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class SpravceOsob {

    private List<Osoba> osoby = new ArrayList<>();
    private TableModel model;

    public SpravceOsob() {
        osoby.add(new Osoba("Lubor", "Pešek", 31, Bydliste.BRNO));
        osoby.add(new Osoba("Magdalena", "Baťková", 31, Bydliste.BRNO));
        osoby.add(new Osoba("Tomio", "Okamura", 49, Bydliste.PRAHA));
        osoby.add(new Osoba("Tomáš", "Fuk", 16, Bydliste.OSTRAVA));

        model = new AbstractTableModel() {
            String[] nazvySloupcu = {"Jméno", "Přijmení", "Věk", "Bydliště"};

            @Override
            public String getColumnName(int column) {
                return nazvySloupcu[column];
            }

            @Override
            public int getRowCount() {
                return osoby.size();
            }

            @Override
            public int getColumnCount() {
                return nazvySloupcu.length;
            }

            @Override
            public Object getValueAt(int row, int column) {
                Osoba osoba = getOsoby().get(row);
                switch (column) {
                    case 0:
                        return osoba.getJmeno();
                    case 1:
                        return osoba.getPrijmeni();
                    case 2:
                        return osoba.getVek();
                    case 3:
                        return osoba.getBydliste().getCity();
                }
                return osoba;
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return true;
            }

        };
    }

    public List<Osoba> getOsoby() {
        return osoby;
    }

    public TableModel getModel() {
        return model;
    }

}
