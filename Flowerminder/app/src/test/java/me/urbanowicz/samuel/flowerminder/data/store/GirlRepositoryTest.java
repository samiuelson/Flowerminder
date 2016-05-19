package me.urbanowicz.samuel.flowerminder.data.store;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import me.urbanowicz.samuel.flowerminder.data.Girl;

import static org.mockito.Mockito.verify;

public class GirlRepositoryTest {


    GirlRepository girlRepository;

    @Mock
    DataStore.SingleEntity<Girl> girlStorage;

    @Before
    public void
    setupForTest() {
        MockitoAnnotations.initMocks(this);
        girlRepository = GirlRepository.getInstance(girlStorage);
    }

    @After
    public void
    cleanupAfterTest() {
        GirlRepository.destroyInstance();
    }

    @Test
    public void
    save_savesGirlToGirlStorage() {
        // Given a Girl object
        final Girl.Builder builder = new Girl.Builder();
        builder.withName("Mia");
        builder.withDesiredFlowersPerMonth(3);
        builder.withEyesColor(0x6B442B);
        builder.withHairColor(0x382F29);
        final Girl girl = builder.build();

        // When girl is saved to GirlRepository
        girlRepository.save(girl);

        // Then persistence repository is called
        verify(girlStorage).save(girl);
    }

    @Test
    public void
    delete_deletesGirlFromGirlStorage() {
        // Given a girl
        final Girl girl = girlRepository.get();

        // When she is deleted from GirlRepository
        girlRepository.delete(girl);

        // Then persistence repository is called
        verify(girlStorage).delete(girl);
    }

    @Test
    public void
    get_fetchesGirlFromGirlStorage() {
        // Given GirlRepository
        // When GirlRepository queried to get Girl
        girlRepository.get();

        // Then it should call GirlStorage
        verify(girlStorage).get();
    }

}
