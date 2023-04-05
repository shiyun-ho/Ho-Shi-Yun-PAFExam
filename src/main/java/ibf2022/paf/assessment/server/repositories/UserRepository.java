package ibf2022.paf.assessment.server.repositories;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.util.comparator.BooleanComparator;

import ibf2022.paf.assessment.server.Utils;
import ibf2022.paf.assessment.server.models.User;

// TODO: Task 3
@Repository
public class UserRepository {

    private static final String SQL_FIND_ALL_BY_USERNAME = "select * from user where username = ?";
    
    @Autowired
    private JdbcTemplate jdbcTemplate; 

    public Optional<User> findUserByUsername(String username){
        SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_FIND_ALL_BY_USERNAME, username); 

        while (!rs.next()){
            return Optional.empty(); 
        }

        return Optional.of(Utils.toUser(rs)); 
    }

    //insert into user(user_id, username, name) values ("1b80118g","freddy","Freddy");
    private static final String SQL_INSERT_USER = "insert into user(user_id, username, name) values (?, ?, ?)"; 

    // public int insertUser(User user){
    //     return jdbcTemplate.update(SQL_INSERT_USER, UUID.randomUUID().toString().substring(0,8),
    //                 user.getUsername(), user.getName()); 
    // }

    public String insertUser(User user) throws Exception{

        int inserted = jdbcTemplate.update(SQL_INSERT_USER, UUID.randomUUID().toString().substring(0,8),
                    user.getUsername(), user.getName()); 
        if (inserted <= 0){
            throw new Exception("Unable to find user"); 
        }
        return "Completed inserting user information.";
    }

    // public String insertUser(User user){
    //     String saved = jdbcTemplate.execute(SQL_INSERT_USER, new PreparedStatementCallback<String>() {
    //         @Override
    //         public String doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
    //             ps.setString(1, UUID.randomUUID().toString().substring(0,8));
    //             ps.setString(2, user.getUsername()); 
    //             ps.setString(3, user.getName());

    //             Boolean rslt = ps.execute(); 

    //             if (rslt == true){
    //                 return rslt; 
    //             } 
                
    //         }
    //     });

    //     return null; 

    // }

    
}
