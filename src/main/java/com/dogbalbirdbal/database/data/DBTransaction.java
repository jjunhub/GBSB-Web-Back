package com.dogbalbirdbal.database.data;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBTransaction {

    void task(Connection connection) throws SQLException;

}
