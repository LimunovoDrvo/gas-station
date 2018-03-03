package com.nis.gasstation.repository;

import com.nis.gasstation.domain.Qrcode;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;
import java.util.List;

/**
 * Spring Data JPA repository for the Qrcode entity.
 */
@SuppressWarnings("unused")
@Repository
public interface QrcodeRepository extends JpaRepository<Qrcode, Long> {

    @Query("select qrcode from Qrcode qrcode where qrcode.user.login = ?#{principal.username}")
    List<Qrcode> findByUserIsCurrentUser();

}
