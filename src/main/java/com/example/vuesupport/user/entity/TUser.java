package com.example.vuesupport.user.entity;

    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author lyq
* @since 2020-04-19
*/
    @Data
    @EqualsAndHashCode(callSuper = false)
    public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String username;

    private String password;

    private String token;


}
