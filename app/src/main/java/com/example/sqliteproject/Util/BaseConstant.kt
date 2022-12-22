package com.example.sqliteproject.Util

class BaseConstant {

        companion object {
            private var self: BaseConstant? = null

            fun instance(): BaseConstant {
                if (self == null) {
                    synchronized(BaseConstant::class.java) {
                        if (self == null) {
                            self = BaseConstant()
                        }
                    }
                }
                return self!!
            }

        }
        // here we have defined variables for our database

        // below is variable for database name
         val DATABASE_NAME = "GEEKS_FOR_GEEKS"

        // below is the variable for database version
         val DATABASE_VERSION = 1

        // below is the variable for table name
        val TABLE_NAME = "gfg_table"

        // below is the variable for id column
        val ID_COL = "id"

        // below is the variable for name column
        val NAME_COl = "name"

        // below is the variable for age column
        val AGE_COL = "age"

}