package Persistence;

import android.provider.BaseColumns;

public final class ContratoBD {
    public static final String Text_Type = " TEXT";
    public static final String Int_Type = " INTEGER";
    public static final String Sep = ",";
    public static final String sql_create_planejamento = "CREATE TABLE " + contratoPlanejamento.table_planejamento_name + " (" +
            contratoPlanejamento._ID + Int_Type + " PRIMARY KEY AUTOINCREMENT" + Sep +
            contratoPlanejamento.column_planejamento_semestre + Int_Type + Sep +
            contratoPlanejamento.column_planejamento_ano + Int_Type + ")";
    public static final String sql_drop_planejamento = "DROP TABLE IF EXISTS " + contratoPlanejamento.table_planejamento_name;

    public static final String sql_create_disciplina = "CREATE TABLE " + contratoDisciplina.table_disciplina_nome + " (" +
            contratoDisciplina._ID + Int_Type + " PRIMARY KEY AUTOINCREMENT" + Sep +
            contratoDisciplina.column_disciplina_nome + Text_Type + Sep +
            contratoDisciplina.column_disciplina_horas + Int_Type + Sep +
            contratoDisciplina.column_disciplina_area + Text_Type + Sep +
            contratoDisciplina.column_disciplina_planejamento + Int_Type + ")";
    public static final String sql_drop_disciplina = "DROP TABLE IF EXISTS " + contratoDisciplina.table_disciplina_nome;

    public ContratoBD(){

    }

    public static final class contratoPlanejamento implements BaseColumns {
        public static final String table_planejamento_name = "planejamento";
        public static final String column_planejamento_semestre = "semestre";
        public static final String column_planejamento_ano = "ano";

    }

    public static final class contratoDisciplina implements BaseColumns{
        public static final String table_disciplina_nome = "disciplina";
        public static final String column_disciplina_nome = "nome";
        public static final String column_disciplina_horas = "horas";
        public static final String column_disciplina_area = "area";
        public static final String column_disciplina_planejamento = "planejamento_id";
    }
}


