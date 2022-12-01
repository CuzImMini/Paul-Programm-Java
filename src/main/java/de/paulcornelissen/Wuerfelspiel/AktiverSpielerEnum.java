package de.paulcornelissen.Wuerfelspiel;

public enum AktiverSpielerEnum {


    EINS("1"), ZWEI("2");

    public AktiverSpielerEnum getOther() {
        return this == EINS ? ZWEI : EINS;
    }

    private final String value;

    AktiverSpielerEnum(String value) {
        this.value = value;
    }

    public String getText() {
        return value;
    }

}
