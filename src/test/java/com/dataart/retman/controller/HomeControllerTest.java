package com.dataart.retman.controller;

import com.dataart.retman.SpittleGenerator;
import com.dataart.retman.domain.Spittle;
import com.dataart.retman.repository.SpittleRepository;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class HomeControllerTest {

//    @Test
//    public void homeTest() throws Exception {
//        HomeController controller = new HomeController();
//        assertEquals("home", controller.home());
//    }

    @Test
    public void testHomePageOne() throws Exception {
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/")).andExpect(view().name("home"));
    }

    @Test
    public void testHomePageTwo() throws Exception {
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/homePage")).andExpect(view().name("home"));
    }

    @Test
    public void shouldShowRecentSpittles() throws Exception {
        int listSize = 10;
        List<Spittle> expectedSpittleList = SpittleGenerator.generateSpittleList(listSize);

        SpittleRepository spittleRepositoryMOCK = Mockito.mock(SpittleRepository.class);
        Mockito.when(spittleRepositoryMOCK.findSpittles(Long.MAX_VALUE, listSize)).thenReturn(expectedSpittleList);

        SpittleController spittleController = new SpittleController(spittleRepositoryMOCK);

        MockMvc mockMvc = standaloneSetup(spittleController).setSingleView(new InternalResourceView("WEB-INF/view/spittles.jsp")).build();
        mockMvc.perform((get("/spittles")))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittleList.toArray())));


//        assertThat(resultSpittleList, IsIterableContainingInOrder.contains(expectedSpittleList.toArray()));
    }

    @Test
    public void shouldShowPagedSpittles() throws Exception {
        int listSize = 10;
        List<Spittle> expectedSpittleList = SpittleGenerator.generateSpittleList(listSize);

        SpittleRepository spittleRepositoryMOCK = Mockito.mock(SpittleRepository.class);
        Mockito.when(spittleRepositoryMOCK.findSpittles(238900, 50)).thenReturn(expectedSpittleList);

        SpittleController spittleController = new SpittleController(spittleRepositoryMOCK);

        MockMvc mockMvc = standaloneSetup(spittleController).setSingleView(new InternalResourceView("WEB-INF/view/spittles.jsp")).build();
        mockMvc.perform((get("/spittles?max=238900&count=50")))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittleList.toArray())));

    }

    private void showList(List tList) {
        for (Object t : tList)
            System.out.println(t);
    }

}
