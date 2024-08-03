package wannabe.backend.schedule.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import lombok.val;
import org.junit.jupiter.api.Test;
import wannabe.backend.schedule.domain.FakeSchedule;
import wannabe.backend.schedule.domain.ScheduleId;
import wannabe.backend.schedule.domain.ScheduleName;
import wannabe.backend.schedule.repository.FakeScheduleEntity;

class ScheduleMapperTest {

  @Test
  void JPA_엔티티로_변환() {
    // given
    // when
    val entity = ScheduleMapper.toEntity(FakeSchedule.builder()
        .name("SCHEDULE_NAME").dateTime(LocalDateTime.MIN).build().create());
    // then
    assertThat(entity.getName()).isEqualTo("SCHEDULE_NAME");
  }

  @Test
  void 도메인_엔티티로_변환() {
    // given
    // when
    val entity = ScheduleMapper.toDomain(FakeScheduleEntity.builder()
        .id(1L).name("SCHEDULE_NAME").dateTime(LocalDateTime.MIN).build().create());
    // then
    assertThat(entity.id())
        .isInstanceOf(ScheduleId.class)
        .extracting(ScheduleId::value)
        .isEqualTo(1L);

    assertThat(entity.name())
        .isInstanceOf(ScheduleName.class)
        .extracting(ScheduleName::value)
        .isEqualTo("SCHEDULE_NAME");
  }
}