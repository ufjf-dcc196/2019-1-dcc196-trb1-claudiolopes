package Persistence;

import android.provider.BaseColumns;

public final class ContratoBD {
    public static final String Text_Type = " TEXT";
    public static final String Int_Type = " INTEGER";
    public static final String Sep = ",";
    public static final String sql_create_planejamento = "CREATE TABLE " + contrato.table_planejamento_name + " (" +
            contrato.column_planejamento_semestre + Int_Type + Sep +
            contrato.column_planejamento_ano + Int_Type + ")";
    public static final String sql_drop_planejamento = "DROP TABLE IF EXISTS " + contrato.table_planejamento_name;

    public static final String sql_create_disciplina = "CREATE TABLE " + contrato.table_disciplina_nome + " (" +
            contrato.column_disciplina_nome + Text_Type + Sep +
            contrato.column_disciplina_horas + Int_Type + Sep +
            contrato.column_disciplina_area + Text_Type + Sep +
            contrato.column_disciplina_planejamento + Int_Type + ")";
    public static final String sql_drop_disciplina = "DROP TABLE IF EXISTS " + contrato.table_disciplina_nome;

    public ContratoBD(){

    }

    public static final class contrato implements BaseColumns {
        public static final String table_planejamento_name = "planejamento";
        public static final String table_disciplina_nome = "disciplina";
        public static final String column_planejamento_semestre = "semestre";
        public static final String column_planejamento_ano = "ano";
        public static final String column_disciplina_nome = "nome";
        public static final String column_disciplina_horas = "horas";
        public static final String column_disciplina_area = "area";
        public static final String column_disciplina_planejamento = "planejamento_id";
    }
}


