package com.example.schoolManagementSystem.entities;

import com.example.schoolManagementSystem.enums.GuardianTypes;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "guardian_types")
public class GuardianType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guardian_type_seq")
    @SequenceGenerator(name = "guardian_type_seq", sequenceName = "guardian_type_seq", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "guardian_type", nullable = false)
    private GuardianTypes guardianType;

    public GuardianType() {
    }

    public GuardianType(Long id, GuardianTypes guardianType) {
        this.id = id;
        this.guardianType = guardianType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GuardianTypes getGuardianType() {
        return guardianType;
    }

    public void setGuardianType(GuardianTypes guardianType) {
        this.guardianType = guardianType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GuardianType that = (GuardianType) o;
        return Objects.equals(id, that.id) && guardianType == that.guardianType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, guardianType);
    }

    @Override
    public String toString() {
        return "GuardianType{" +
                "id=" + id +
                ", guardianType=" + guardianType +
                '}';
    }
}
