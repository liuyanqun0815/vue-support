package com.example.vuesupport.home.entity;

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
* @since 2020-04-11
*/
    @Data
        @EqualsAndHashCode(callSuper = false)

    public class THome implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;

    private String name;

    private String code;

    private Integer tel;

    private String address;

    private Long uU;


}
