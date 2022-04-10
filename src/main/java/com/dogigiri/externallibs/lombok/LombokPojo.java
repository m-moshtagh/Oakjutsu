package com.dogigiri.externallibs.lombok;

import com.dogigiri.core.blocks.BlocksDemo;
import com.dogigiri.core.enumeratedtypes.Color;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.EqualsExclude;
import org.apache.commons.lang3.builder.HashCodeExclude;

import java.time.Instant;
import java.util.List;

@Data
@Slf4j
@EqualsAndHashCode(exclude = "blocksDemos")
public class LombokPojo {
    private long id;
    private String name;
    private String model;
    private Instant time;
    @HashCodeExclude
    @EqualsExclude
    private List<Color> colors;
    private List<BlocksDemo> blocksDemos;
}
