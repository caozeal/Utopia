package com.caozeal.match;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>创建时间：2019/8/21 18:39
 * <p>PACKAGE_NAME
 *
 * @author caozhiyong
 * @version 1.0
 */
@Builder
@Setter
@Getter
@ToString
public class BestMatchingData {

    private List<String> words;

    private int distance;
}
