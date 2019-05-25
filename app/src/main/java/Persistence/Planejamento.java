package Persistence;

import android.provider.BaseColumns;

public final class Planejamento {
    public static final String Text_Type = " TEXT";
    public static final String Int_Type = " INTEGER";
    public static final String Sep = ",";
    public static final String SQL_CREATE_PLANEJAMENTO = "CREATE TABLE " + planejamento.TABLE_NAME + " (" +
            planejamento._ID + Int_Type + " PRIMARY KEY AUTOINCREMENT" + Sep +
            planejamento.COLUMN_NAME_ANO + Int_Type + Sep +
            planejamento.COLUMN_NAME_SEMESTRE + Int_Type + Sep +
            planejamento.COLUMN_NAME_PORCENTAGEM + Text_Type + Sep +
            planejamento.COLUMN_NAME_HORAS + Text_Type + ")";
    public static final String SQL_Drop_Planejamento = "DROP TABLE IF EXISTIS" + planejamento.TABLE_NAME;

    public Planejamento(){

    }

    public static final class planejamento implements BaseColumns {
        public static final String TABLE_NAME = "planejamento";
        public static final String COLUMN_NAME_ANO = "ano";
        public static final String COLUMN_NAME_SEMESTRE = "semestre";
        public static final String COLUMN_NAME_PORCENTAGEM = "porcentagem";
        public static final String COLUMN_NAME_HORAS = "horas";
    }
}
