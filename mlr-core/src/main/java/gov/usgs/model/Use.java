package gov.usgs.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Use", propOrder
	= {"id", "rank", "code", "name"
	})

@XmlRootElement(name = "Use")
public class Use {

	@XmlElement(name = "id")
	private Long id = null;

	@XmlType(name = "RankEnum")
	@XmlEnum(Long.class)
	public enum RankEnum {

		@XmlEnumValue("1")
		NUMBER_1(Long.valueOf(1)),
		@XmlEnumValue("2")
		NUMBER_2(Long.valueOf(2)),
		@XmlEnumValue("3")
		NUMBER_3(Long.valueOf(3));

		private Long value;

		RankEnum(Long v) {
			value = v;
		}

		public Long value() {
			return value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}

		public static RankEnum fromValue(String v) {
			for (RankEnum b : RankEnum.values()) {
				if (String.valueOf(b.value).equals(v)) {
					return b;
				}
			}
			return null;
		}
	}

	@XmlElement(name = "rank")
	private RankEnum rank = null;

	@XmlElement(name = "code")
	private String code = null;

	@XmlElement(name = "name")
	private String name = null;

	/**
	 * Get id
	 *
	 * @return id
	 *
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get rank
	 *
	 * @return rank
	 *
	 */
	public RankEnum getRank() {
		return rank;
	}

	public void setRank(RankEnum rank) {
		this.rank = rank;
	}

	/**
	 * Get code
	 *
	 * @return code
	 *
	 */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Get name
	 *
	 * @return name
	 *
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Use {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    rank: ").append(toIndentedString(rank)).append("\n");
		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4
	 * spaces (except the first line).
	 */
	private static String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
