package com.see.any.modol;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ReqBody {
    private String Name;
    private String Email;
}
