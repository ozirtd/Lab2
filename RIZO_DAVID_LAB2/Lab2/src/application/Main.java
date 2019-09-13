package application;
	
import java.time.LocalDate;
import java.util.Date;

import exceptions.ExistentOwnerException;
import exceptions.ExistentPetException;
import model.Owner;
import model.Pet;
import model.PetsClub;



public class Main {
	
	private static PetsClub petsclub;
	
	
	
	public Main() {
		petsclub = new PetsClub();
	}
	
	public static void main(String[] args) {
		System.out.println("Bienvenido");
		System.out.println("Bienvenido");
		System.out.println("Bienvenido");
		System.out.println("Bienvenido");
		System.out.println("Bienvenido");
	}
	
	public PetsClub getPetsClub() {
		return this.petsclub;
	}
	
	public static void registerOwner(Owner new_owner) throws ExistentOwnerException {
		petsclub.registerOwner(new_owner);
	}
	
	public static void deleteOwner(String id) {
		petsclub.deleteOwner(id);
	}
	
	public static Owner searchOwner(String condition) {
		return petsclub.searchOwner(condition);
	}
	
	public static Owner searchOwnerByName(String name) {
		return petsclub.searchOwnerByName(name);
	}
	
	public static Owner searchOwnerById(String id) {
		return petsclub.searchOwnerById(id);
	}
	
	public static void modifyOwner(Owner owner) {
		petsclub.modifyOwner(owner);
	}
	
	public static void registerPet(Pet pet,Owner owner) throws ExistentPetException {
		petsclub.registerPet(pet, owner);
	}
	
	public static void deletePet(String name,Owner owner) {
		petsclub.deletePet(name, owner);;
	}
	
	public static Pet searchPet(String condition) {
		return petsclub.searchPet(condition);
	}
	
	public static Pet searchPetByName(String name) {
		return petsclub.searchPetByName(name);
	}
	
	public static Pet searchPetByBirthdate(LocalDate birthdate) {
		return petsclub.searchPetByBirthdate(birthdate);
	}
	
	public static void modifyPet(Pet pet) {
		petsclub.modifyPet(pet);
	}
	
	public static Owner consultOwners(LocalDate criteria) {
		return petsclub.consultOwners(criteria);
	}

	public static Pet consultPets(LocalDate criteria) {
		return petsclub.consultPets(criteria);
	}
	
	public static boolean contains(Owner owner) {
		return petsclub.containsOwner(owner);
	}
	
	public static Owner repetidos(LocalDate criteria) {
		return petsclub.consultRepetidos(criteria);
	}
	
	
	
}
