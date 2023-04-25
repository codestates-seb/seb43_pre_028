package server.server.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import server.server.answer.entity.Answer;
import server.server.answervote.entity.AnswerVote;
import server.server.audit.BaseEntity;
import server.server.question.entity.Question;
import server.server.questionVote.entity.QuestionVote;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "USERS")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "STATUS")
    private UserStatus userStatus = UserStatus.USER_EXIST;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false, updatable = false,unique = true,columnDefinition = "TEXT")
    private String email;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String password;


    @Column(nullable = false)
    private String image = "https://mblogthumb-phinf.pstatic.net/MjAyMDA2MTBfMTY1/MDAxNTkxNzQ2ODcyOTI2.Yw5WjjU3IuItPtqbegrIBJr3TSDMd_OPhQ2Nw-0-0ksg.8WgVjtB0fy0RCv0XhhUOOWt90Kz_394Zzb6xPjG6I8gg.PNG.lamute/user.png?type=w800";


    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public enum UserStatus {
        USER_NOT_EXIST("존재하지 않는 회원"),
        USER_EXIST("활동 회원");

        @Getter
        private String status;

        UserStatus(String status) {
            this.status = status;
        }
    }

    @Column(nullable = true)
    private String role; //USER

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Answer> answers = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<AnswerVote> answerVotes = new ArrayList<>();

//    public List<String> getRoleList(){
//        if(this.roles.length()>0){
//            return Arrays.asList(this.roles.split(","));
//        }
//        return new ArrayList<>();
//    }

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Question> questions = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<QuestionVote> questionVotes = new ArrayList<>();


}