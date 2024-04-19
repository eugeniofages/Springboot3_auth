package authspring.authspringboot3.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class AdminController {


    @GetMapping
    @PreAuthorize("hasAuthority('admin:read')")
    public String get() {
        return "GET:: admin controller";
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin:create')")

    public String post() {
        return "post:: admin controller";
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin:update')")
    public String put() {
        return "put:: admin controller";
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('admin:read')")
    public String delete() {
        return "delete:: admin controller";
    }
}


