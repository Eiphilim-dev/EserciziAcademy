package EserciziGiorno11.Esercizio1;

public enum Cardinal {
    NORD, NORD_NORD_EST, NORD_EST, EST_NORD_EST,
    EST, EST_SUD_EST, SUD_EST, SUD_SUD_EST,
    SUD, SUD_SUD_OVEST, SUD_OVEST, OVEST_SUD_OVEST,
    OVEST, OVEST_NORD_OVEST, NORD_OVEST, NORD_NORD_OVEST; 

    public boolean isOpposite(Cardinal c) {
        switch (this) {
            case NORD: return c == SUD;
            case NORD_NORD_EST: return c == SUD_SUD_OVEST;
            case NORD_EST: return c == SUD_OVEST;
            case EST_NORD_EST: return c == OVEST_SUD_OVEST;
            case EST: return c == OVEST;
            case EST_SUD_EST: return c == OVEST_NORD_OVEST;
            case SUD_EST: return c == NORD_OVEST;
            case SUD_SUD_EST: return c == NORD_NORD_OVEST;
            case SUD: return c == NORD;
            case SUD_SUD_OVEST: return c == NORD_NORD_EST;
            case SUD_OVEST: return c == NORD_EST;
            case OVEST_SUD_OVEST: return c == EST_NORD_EST;
            case OVEST: return c == EST;
            case OVEST_NORD_OVEST: return c == EST_SUD_EST;
            case NORD_OVEST: return c == SUD_EST;
            case NORD_NORD_OVEST: return c == SUD_SUD_EST;
            default: return false;
        }
    }

    public static Cardinal mix(Cardinal c1, Cardinal c2) {
        if (c1 == c2) return c1;
        if (c1.isOpposite(c2)) return null;

        int p1 = c1.ordinal();
        int p2 = c2.ordinal();

        
        if (Math.abs(p1 - p2) > 8) {
            if (p1 < p2) p1 += 16;
            else p2 += 16;
        }

        switch ((p1 + p2) / 2 % 16) {
            case 0:  return NORD;
            case 1:  return NORD_NORD_EST;
            case 2:  return NORD_EST;
            case 3:  return EST_NORD_EST;
            case 4:  return EST;
            case 5:  return EST_SUD_EST;
            case 6:  return SUD_EST;
            case 7:  return SUD_SUD_EST;
            case 8:  return SUD;
            case 9:  return SUD_SUD_OVEST;
            case 10: return SUD_OVEST;
            case 11: return OVEST_SUD_OVEST;
            case 12: return OVEST;
            case 13: return OVEST_NORD_OVEST;
            case 14: return NORD_OVEST;
            case 15: return NORD_NORD_OVEST;
            default: return null;
        }
    }
}
