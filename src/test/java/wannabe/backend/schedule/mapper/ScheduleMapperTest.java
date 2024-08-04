package wannabe.backend.schedule.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import lombok.val;
import org.junit.jupiter.api.Test;
import wannabe.backend.schedule.domain.FakeScheduleFactory;
import wannabe.backend.schedule.domain.ScheduleId;
import wannabe.backend.schedule.domain.ScheduleName;
import wannabe.backend.schedule.repository.FakeScheduleEntityFactory;

class ScheduleMapperTest {

  @Test
  void JPA_엔티티로_변환() {
    // given
    // when
    val entity = ScheduleMapper.toEntity(
        FakeScheduleFactory.create("SCHEDULE_NAME", LocalDateTime.MIN));
    // then
    assertThat(entity.getName()).isEqualTo("SCHEDULE_NAME");
  }

  @Test
  void 도메인_엔티티로_변환() {
    // given
    // when
    val entity = ScheduleMapper.toDomain(
        FakeScheduleEntityFactory.create(1L, "SCHEDULE_NAME", LocalDateTime.MIN));
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