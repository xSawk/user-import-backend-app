package pl.lukasik.backend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;


@Getter
@Setter
@Builder
@AllArgsConstructor
public class UploadStatistic {
    private String fileName;
    private long uploadDuration;
    private int size;
}
