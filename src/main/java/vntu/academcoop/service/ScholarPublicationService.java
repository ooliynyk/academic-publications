package vntu.academcoop.service;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vntu.academcoop.dto.AuthorDetails;
import vntu.academcoop.model.Publication;
import vntu.academcoop.repository.PublicationRepository;

@Service
public class ScholarPublicationService implements PublicationService {

	private final PublicationRepository publicationRepository;

	@Autowired
	public ScholarPublicationService(PublicationRepository publicationRepository) {
		this.publicationRepository = publicationRepository;
	}

	@Override
	public Collection<Publication> fetchAllPublicationsByAuthor(AuthorDetails author) {
		return publicationRepository.findAllPublicationsByAuthorId(author.getId());
	}

	@Override
	public Collection<Publication> fetchAllPublicationsByAuthorBetweenYears(AuthorDetails author, Date fromYear,
			Date toYear) {
		Collection<Publication> publications = publicationRepository.findAllPublicationsByAuthorId(author.getId());

		if (fromYear != null || toYear != null) {
			publications = publications.stream().filter(p -> p.getPublicationDate() != null)
					.filter(p -> afterOrInYear(p.getPublicationDate(), fromYear))
					.filter(p -> beforeOrInYear(p.getPublicationDate(), toYear)).collect(Collectors.toList());
		}

		return publications;

	}

	private static boolean afterOrInYear(Date year, Date fromYear) {
		return fromYear != null ? year.compareTo(fromYear) >= 0 : true;
	}

	private static boolean beforeOrInYear(Date year, Date toYear) {
		return toYear != null ? year.compareTo(toYear) <= 0 : true;
	}

}
