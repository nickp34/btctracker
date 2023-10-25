package com.coin.tracker;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.coin.tracker.controllers.UserCoinController;
import com.coin.tracker.entities.UserCoin;
import com.coin.tracker.repositories.UserCoinRepository;

// @SpringBootTest
@WebMvcTest(UserCoinController.class)
class TrackerApplicationIntegrationTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private UserCoinRepository userCoinRepository;

  @Test
  public void testGetAllUserCoin() throws Exception {
    List<UserCoin> userCoins = new ArrayList<>();

    Long userId = 200L;

    UserCoin btc = UserCoin.builder()
      .address("3E8ociqZa9mZUSwGdSmAEMAoAxBK3FNDcd")
      .coinId(100L)
      .userId(userId)
      .balance(BigDecimal.valueOf(.01465180))
      .lastTimeSync(null)
      .build();

    UserCoin sol = UserCoin.builder()
      .address("533iFWaFVXptckxTV5vgZ3VaRTTMzMa7EEvgi4JsRDrL")
      .coinId(400L)
      .userId(userId)
      .balance(BigDecimal.valueOf(153.45))
      .lastTimeSync(null)
      .build();

    userCoins.add(btc);
    userCoins.add(sol);

    given(userCoinRepository.findByUserId(userId)).willReturn(userCoins);

    mvc.perform(get("/api/v1/coins/"+userId.toString())
      .contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$", hasSize(2)));
  }

  //Would consider test the rest of the controller methods
  //Would consider test inserting data and retreving it instead of mocking for full integration tests

  @Test
  public void testGetSingleCoin() {
    // TODO
  }

  @Test
  public void testTrackNewCoin() {
    // test exceptions/already tracking/etc
  }

  @Test void testUntrackCoin() {
    // TODOD
  }
}
